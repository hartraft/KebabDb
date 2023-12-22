package be.hartraft

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext

import org.fusesource.jansi.AnsiConsole;
import java.io.PrintWriter;
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import org.jline.reader.*;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.LineReaderImpl;

@Command(name = "KebabDb", description = ["A toy DB implementation that keeps you hungry for more"],
	version = ["0.1"],
        mixinStandardHelpOptions = true,
	footer = ["", "Press Ctrl-D to exit."],
	subcommands = [ TableCommand::class ])
class KebabDbCommand() : Runnable {
    var out: PrintWriter? = null;
    
    fun setReader(reader: LineReader){
        out = reader.getTerminal().writer()
    }

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose : Boolean = false

    override fun run() {
	println("Welcome to KebabDB \uD83C\uDF2F")
        out?.println(CommandLine(this).getUsageMessage())
	/*
        // business logic here
        if (verbose) {
            println("Hi!")
        }
	*/
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
	    AnsiConsole.systemInstall()
	    try {

	    } catch (t: Throwable) {
	        t.printStackTrace()
	    } finally {
		AnsiConsole.systemUninstall()
	    }
            //PicocliRunner.run(KebabDbCommand::class.java, *args)
        }
    }
}

/**
* A command with some options to demonstrate completion.
*/
@Command(name = "cmd", mixinStandardHelpOptions = true, version = ["1.0"],
    description = ["Command with some options to demonstrate TAB-completion.",
	    " (Note that enum values also get completed.)"],
    //subcommands = {Nested.class, CommandLine.HelpCommand.class}
    )
class TableCommand() : Runnable {
    override fun run() {
        //out.println(CommandLine(this).getUsageMessage())
    }
}
