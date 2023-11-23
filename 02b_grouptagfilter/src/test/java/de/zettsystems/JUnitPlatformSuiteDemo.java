package de.zettsystems;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("This is a suite")
@SelectPackages({"de.zettsystems.fizzbuzz", "de.zettsystems.legacy", "de.zettsystems.grouped"})
@SelectClasses({
        MoreTest.class
})
@ExcludeTags("buzz")
public class JUnitPlatformSuiteDemo {
}
