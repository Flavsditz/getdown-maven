package org.bitbucket.joxley.mavengetdown;

import com.threerings.getdown.data.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a basic digest
 *
 * @goal basicDigest
 */
public class BasicDigest extends AbstractMojo {
    /**
     * Application directory
     *
     * @parameter default-value="target"
     */
    private File appdir;

    /**
     * Application files to create a digest for
     *
     * @parameter default-value="target/appfiles.txt"
     */
    private File appfiles;

    /**
     * Output digest file
     *
     * @parameter default-value="target/digest.txt"
     */
    private File digest;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            List<String> files = Files.readAllLines(appfiles.toPath(), Charset.defaultCharset());
            List<Resource> resources = new ArrayList<>();
            for (String file : files) {
                String path = new File(appdir, file).getPath();
                getLog().debug("Processing file " + file);
                Resource resource = new Resource(file, null, new File(path), false);
                resources.add(resource);
            }

            com.threerings.getdown.data.Digest.createDigest(resources, digest);
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to execute mojo", e);
        }

    }
}
