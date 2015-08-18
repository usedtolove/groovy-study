/*
	This is the Geb configuration file.
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni

waiting {
	timeout = 3
}

// default is to use firefox
FirefoxProfile fxProfile = new ProfilesIni().getProfile("default");
driver = { new FirefoxDriver(fxProfile) }

baseUrl = "http://localhost:18888/autoCheck/"
