package com.capgemini.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.capgemini.jpa.tasks.Task1;
import com.capgemini.jpa.tasks.Task2;
import com.capgemini.jpa.tasks.Task3;
import com.capgemini.jpa.tasks.Task4;
import com.capgemini.jpa.tasks.Task5;
import com.capgemini.jpa.tasks.Task6;
import com.capgemini.jpa.tasks.Task7;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	Task1.class,
	Task2.class,
	Task3.class,
	Task4.class,
	Task5.class,
	Task6.class,
	Task7.class
	})
public class AllTasksSuite {

}
