

task callStaticMethod << {
	// project.ext.TEST_PROJ_EXT_VALUE = 100
	System.setenv("XXX", "100")
	DummyClass.StaticMethod()
}

task execEchoAndSleep << {
	DummyClass.ExecEchoAndSleep("hello from groovy", 5)
}