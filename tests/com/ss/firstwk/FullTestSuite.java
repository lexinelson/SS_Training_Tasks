package com.ss.firstwk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ss.firstwk.fri.FriTestSuite;
import com.ss.firstwk.thurs.ThursTestSuite;

@RunWith(Suite.class)
@SuiteClasses({FriTestSuite.class, ThursTestSuite.class})

public class FullTestSuite {

}
