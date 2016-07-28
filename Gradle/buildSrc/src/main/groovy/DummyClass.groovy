

class DummyClass {
	static void StaticMethod() {
		println "DummyClass StaticMethod called!"
		println System.env.XXX
		// println project.ext.TEST_PROJ_EXT_VALUE
	}

	static void ExecEchoAndSleep(String content, int time) {
		exec {
			executable = "echo"
			args = [content]
		}

		println "sleep for: " + time
		exec {
			executable = "sleep"
			args = [time]
		}
		println "wake up!"
	}
}