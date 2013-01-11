/*
 * Copyright (c) 2008 luminis
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * - Neither the name of the Luminis nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.luminis.cmc;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.apache.felix.shell.Command;
import org.osgi.framework.BundleContext;

public class FelixCmCommand implements Command {
	
	private BundleContext context;

	public FelixCmCommand(BundleContext context) {
		this.context = context;
	}

	public void execute(String commandLine, PrintStream out, PrintStream err) {
		
	    List<String> args = parseCommandLine(commandLine);
		new CmCommandProcessor(context).execute(args.subList(1, args.size()), commandLine, out, err);
	}

	public String getName() {
		return "cm";
	}

	public String getShortDescription() {
		return "access OSGi Configuration Admin service";
	}

	public String getUsage() {
		return "cm help|list|get...";
	}
	
	protected List<String> parseCommandLine(String commandLine)
	{
	    return Arrays.asList(commandLine.split(" +"));
	}
}
