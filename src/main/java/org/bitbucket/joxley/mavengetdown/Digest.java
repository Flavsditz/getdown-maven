package org.bitbucket.joxley.mavengetdown;

import com.threerings.getdown.tools.Digester;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.IOException;

/**
 * Create the digest
 *
 * @goal digest
 */
public class Digest extends AbstractMojo {
    /**
     * Application directory
     *
     * @parameter default-value="target"
     */
    private File appdir;

    public void execute() throws MojoExecutionException {
        try {
            Digester.createDigest(appdir);
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to create digest", e);
        }
    }
}
