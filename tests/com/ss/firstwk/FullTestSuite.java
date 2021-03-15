package com.ss.firstwk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ss.firstwk.fri.FriTestSuite;
import com.ss.firstwk.fri.proj.WeekOneProjTestSuite;
import com.ss.firstwk.thurs.ThursTestSuite;

/**
 * Full Test Suite - All existing tests for week1 directories
 * @author lexne
 *
 */
@RunWith(Suite.class)
@SuiteClasses({FriTestSuite.class, ThursTestSuite.class, WeekOneProjTestSuite.class})

public class FullTestSuite {

}
