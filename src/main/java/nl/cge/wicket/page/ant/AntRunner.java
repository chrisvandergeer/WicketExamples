package nl.cge.wicket.page.ant;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntRunner {
	
	private ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
	private ByteArrayOutputStream stdErr = new ByteArrayOutputStream();
	
	public void executeTask(String taskname, Map<String, String> userSettings) {
		try {
			Project project = new Project();
			for (String name : userSettings.keySet()) {
				project.setUserProperty(name, userSettings.get(name));
			}
			ProjectHelper.getProjectHelper().parse(project, new File("build.xml"));
			DefaultLogger consoleLogger = getConsoleLogger();
			project.addBuildListener(consoleLogger);        		
	        project.executeTarget(taskname);
		} catch (RuntimeException e) {
			writeStdError(e.getMessage());
		}
	}
	
	private void writeStdError(String message) {
		try {
			stdErr.write(message.getBytes());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public String getStdOut() {
		return stdOut.toString();
	}
	
	public String getStdErr() {
		return stdErr.toString();
	}

    private DefaultLogger getConsoleLogger() {
        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(new PrintStream(stdErr));        
        consoleLogger.setOutputPrintStream(new PrintStream(stdOut));
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);         
        return consoleLogger;
    }
}
