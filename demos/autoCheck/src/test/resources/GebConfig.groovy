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
	println "Windows OS";
	FirefoxProfile fxProfile = new ProfilesIni().getProfile("default");
	driver = { new FirefoxDriver(fxProfile) }
}else{
	println "Other OS"
	driver = { new FirefoxDriver() }
}

baseUrl = "http://localhost:18888/autoCheck/"
