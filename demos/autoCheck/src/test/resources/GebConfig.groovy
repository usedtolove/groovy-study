/*
	This is the Geb configuration file.
	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.apache.tools.ant.taskdefs.condition.Os
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni

waiting {
	timeout = 3
}

// default is to use firefox
if (Os.isFamily(Os.FAMILY_WINDOWS)) {
	println "Geb for Windows";
	FirefoxProfile fxProfile = new ProfilesIni().getProfile("default");
	driver = { new FirefoxDriver(fxProfile) }
}else if(Os.isFamily(Os.FAMILY_UNIX)){
	println "Geb for FAMILY_UNIX"
	driver = { new FirefoxDriver() }
}else{
	println "Geb for Other OS"
	driver = { new FirefoxDriver() }
}

//baseUrl = "http://localhost:18888/autoCheck/"
baseUrl = "http://192.168.3.169:18888/ssh_exam_guhaixiang/"
