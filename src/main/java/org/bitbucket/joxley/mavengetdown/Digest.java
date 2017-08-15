package org.bitbucket.joxley.mavengetdown;

import com.threerings.getdown.tools.Digester;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

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
            final String[] strings = {appdir.getAbsolutePath()};
            Digester.main(strings);
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to create digest", e);
        } catch (GeneralSecurityException ge) {
            throw new MojoExecutionException("Failed to create digest due to security concerns", ge);
        }
    }
}
