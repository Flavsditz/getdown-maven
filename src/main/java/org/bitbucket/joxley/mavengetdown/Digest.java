package org.bitbucket.joxley.mavengetdown;

import java.io.File;

import com.threerings.getdown.tools.Digester;

/**
 * Create the digest
 * 
 * @goal digest
 */
public class Digest {
	/**
	 * Application directory
	 * 
	 * @parameter default-value="target"
	 */
	private File appdir;

	public void execute() throws Exception {
		Digester.createDigest(appdir);
	}
}
