import java_cup.runtime.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static <S, T> void main(String args[])
	{
		int argsCount = args.length;
		if(argsCount == 0)
		{
			System.out.println("Usage<stuff> <files>");
			System.exit(0);
		}

		ArrayList<String> filenames = new ArrayList<>();
		for (int i = 0; i < argsCount; i++)
		{
			String arg = args[i];
			filenames.add(arg);
		}

		Walker<Environment<SmplType>, SmplType> walker = new SmplInterpreter();

		// NOTE(afb) :: Java retardation
		// Class<? extends Walker<S, T>> wclass =
		// (Class<? extends Walker<S, T>>) Class.forName("SmplInterpreter");
		// walker = (wclass.newInstance());

		for (String filename : filenames)
		{
			Reader fileReader = null;
			try
			{
				
				fileReader = new FileReader(filename);
				System.out.println("Processing " + filename + "...");
				readLines(fileReader, walker);
			}
			catch(FileNotFoundException fnfe)
			{
				System.err.println(fnfe.getMessage());
			}
			finally
			{
				
				try
				{ 
					if(fileReader != null) fileReader.close();
				}
				catch(IOException ioe)
				{
					System.err.println(ioe.getMessage());
				}
			}
		}	   
	}


	private static <S, T> void readLines(Reader in, Walker<S, T> walker)
	{
		LineNumberReader scanner = null;
		try
		{
			StringBuilder input = new StringBuilder(256);
			scanner = new LineNumberReader(in);
			while(true)
			{
				try
				{

					String line = scanner.readLine();
					while (line != null && !line.equals("."))
					{
						// we add a newline character so the lexer can see it
						input.append(line + "\n");
						line = scanner.readLine();
					}

					if (input.toString().equals("")) { break; }
					else
					{
						parseWalkShow(new StringReader(input.toString()),
									  walker);
						
						input.delete(0, input.length());
					}
				}
				catch(IOException ioe)
				{
					System.err.println(ioe.getMessage());
				}
			}
		}
		finally
		{
			try
			{ 
				scanner.close();
			}
			catch(IOException ioe)
			{
				System.err.println(ioe.getMessage());
			}
		}

	}

	public static <S, T> void parseWalkShow(Reader reader, Walker<S, T> walker)
	{
		T result = walker.run(reader);

		if(result instanceof SmplType)
		{
			SmplType r = (SmplType)result;
			System.out.println("\nResult: " + r.toString());
		}
		
    }

}
