package com.bircekilinc.sensor;

import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Sensor implements Closeable {
	private final String m_url;
	private boolean m_open;

	public Sensor(String url)
	{
		//...
		RandomGenerator randomGenerator = new Random();

		if (randomGenerator.nextBoolean())
			throw new IllegalArgumentException("Url not found");

		m_url = url;
		m_open = true;
		Console.writeLine("Connected to %s", m_url);
	}

	public boolean isOpen()
	{
		return m_open;
	}

	public void doWork() throws IOException
	{
		//...
		RandomGenerator randomGenerator = new Random();

		if (randomGenerator.nextBoolean())
			throw new IllegalStateException("Illegal state for sensor:" + m_url);

		if (randomGenerator.nextBoolean())
			throw new IOException("IO Problem occurs");

		Console.writeLine("Working on sensor at %s", m_url);
	}

	public void close() throws IOException
	{
		m_open = false;
		Console.writeLine("Sensor at connection closed!...");
	}
}
