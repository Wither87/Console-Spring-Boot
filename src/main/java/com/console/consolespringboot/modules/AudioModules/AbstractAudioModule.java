package com.console.consolespringboot.modules.AudioModules;

import com.console.consolespringboot.modules.Module;
import com.console.consolespringboot.utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractAudioModule implements Module {
    private static final List<String> _supportedFormats = Arrays.asList("wav", "mp3");
    @Override
    public boolean isSupportedFormat(File file) {
        return _supportedFormats.contains(FileUtils.getFileExtension(file));
    }

    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file);
}
