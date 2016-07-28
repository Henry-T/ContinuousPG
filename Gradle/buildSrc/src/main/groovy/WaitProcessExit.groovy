import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

class WaitProcessExit extends DefaultTask {
    String image
    int timeOut  // in seconds

    @TaskAction
    def waitProcessExit() {
        def processRunning = true
        def startTime = new Date().toTimestamp();

        while (processRunning) {
            def process = new ProcessBuilder("processExistByImage.bat", image).redirectErrorStream(true).start()
            process.inputStream.eachLine{println it}
            process.waitFor()
            def exitCode = process.exitValue()
            println "check image exit code: "+exitCode
            processRunning = exitCode==0

            def deltaTime = new Date().toTimestamp()-startTime;
            if (deltaTime > timeOut) {
                break;
            }
        }

        if (processRunning)
            throw new Exception("wait timed out!")
        else
            println "waited process exited, continue"
    }
}

