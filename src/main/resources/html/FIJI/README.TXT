FIJI README.TXT

This is the installation documentation for FIJI. Please read this document
before attempting to use the software.

This is the beta release of version 1.2 of FIJI ForthIsh Java Interpreter.

FIJI and all its source files and documentation are
Copyright 1998, 1999, 2000, 2001
Jack J. Woehr, PO Box 51, Golden, Colorado 80402-0051
jax@softwoehr.com http://www.softwoehr.com
jwoehr@fiji.sourceforge.net http://fiji.sourceforge.net

--------------------------------------------------------------------
FIJI is now maintained/distributed from http://fiji.sourceforge.net.
--------------------------------------------------------------------

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

    The GNU Public License in this distribution is the file COPYING.
____________________________________________________________________

INSTALLATION
------------
The program is distributed as a Zip archive. Unpacking the archive
creates a directory tree of which the top level is:

             +-fiji.{version}.jar (FIJI's Java class *and source* files)
             |
             +-html<DIR> (the documentation for FIJI)
             |
             +-COPYING (The Gnu Public License)
             |
             +-README.TXT (this file).
             |
             +-script<DIR> (contains the jakarta-ant build.xml file to build FIJI)

Add fiji.{version}.jar to your classpath to make the library accessible to
java, or use the -c or -classpath switches to 'jre' or 'java' to make
fiji accessible to Java.

RTFM
----
To learn how to launch and use FIJI, read the HTML documentation.
Point your browser at the 'html' subdirectory which should bring up
html/index.html which is the root of the documentation for this product.

Quick Start
-----------
For the impatient, however, here's the scoop: Once fiji.{version}.jar is
in the CLASSPATH

      java com.SoftWoehr.FIJI.FIJI

starts the command-line form of FIJI and

      java com.SoftWoehr.FIJI.FIJIGui

starts the GUI version of FIJI.

Source Code
-----------
The source code for FIJI is in fiji.{version}.jar along with the classes.
To examine/modify/recompile the source code, please use the Sun jar tool
to extract the directory hiearchy, e.g.,

           jar xf fiji.{version}.jar

Examples
--------

Examples are found in the class hierarchy inside the jar file, under
com/SoftWoehr/FIJI/examples.

To use the examples, change directory to the specific example directory
or subdirectory, start FIJI and use the 'load' command to load the
example file. For example, change directory to examples/io, start fiji,
and enter

       cat.fiji load

If you follow links from index.html to the main FIJI documentation,
the documentation itself cant display FIJI running as an applet if you
have the Java 1.3 plugin installed in your browser. Currently FIJI doesn't
run as a sandbox applet, throwing a security violation.

There may be additional files in the root directory of the FIJI distribution.
You should examine all additional files.

Changes from Previous Versions
------------------------------
1.2 beta
    2001-08-15 ... Fixed bug in interpreter.interpret (popping empty tokenizer
                   stack).
               ... First SourceForge release!
1.2 alpha
    2000-10-15 ... New GUI
                   Cleanups in engine
    
1.1 1999-05-23 ... Added `null` to language, and Boolean `and`, `or`, `xor`.
                   Fixed ` = <> ` so they will also compare null.
                   "Tick" ' now returns null if input stream empty,
                   used to throw exception.
1.0 1999-01-31 ... Various bug fixes, e.g., dimarray.
               ... Improved documentation, e.g., "Theory of" doc.
0.9 1999-01-04 ... Wordlists now push definitions which are redefined.
               ... Bug in engine.callJavaMethod() fixed.
               ... Bug in engine.findField() fixed.
               ... Thanx to Pai Jih-Tung of La Jolla, CA for some
                   bug reports and good questions.
               ... Command line loading of FIJI source code.
0.8 1998-12-30 ... Loading source code from files, more utilities, examples.
0.7 1998-12-27 ... More control flow and various utilities.
0.6 1998-12-24 ... Iteration, decompilation, displaying wordlists.
0.5 1998-12-21 ... Literals, compilation words, FIJI running as an applet.
0.4 1998-12-18 ... Definitions, control flow, value, variable, many bug fixes.
0.3 1998-12-14 ... First public release.

Notes about 1.2
---------------
It's been a while! As I have gotten busier in Java (visit http://www.softwoehr.com
to see some of what I have been up to) I have begun realize the usefulness of FIJI
as an automated testing tool.

So I have fixed the GUI so it is easier to use and more reliable, made a few cleanups
in the engine, and dusted off the project so it is easier to work on. The next feature
I would like to add is save and restore wordlists (dictionary persistence). Yes, I
know I have been promising this but now Java is in better shape than when I started
this so it's probably worth doing now.

Notes about 1.1
---------------
Thanx to Andrew Holt of Sun UK who pointed out that and/or/xor were missing.
Bugs and omissions are fixed. I still don't have access to a stable JDK 1.2
so I'm not working on FIJI much. If anyone is using it and needs more
functionality, let me know!

Notes about 1.0
---------------
I've pretty much added all the features I want for now. Dictionary persistence
is going to have to wait until I switch over to JDK 1.2 which doesn't yet
exist on Linux to my knowledge. Dictionary persistence needs the ordered
collections of JDK 1.2, it's too much code to do this by hand in 1.1.

All comments, requests and bug reports welcome to FIJI@softwoehr.com.

Most feature requests will be deferred to FIJI 1.x ... Features I'm
considering include a logic engine and JDBC access. Some of this may
just be written in FIJI itself, instead of in Java in the engine.

---
Jack Woehr
Fairmount, Colorado
2001-08-25

