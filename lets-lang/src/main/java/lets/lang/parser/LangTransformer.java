/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lets.lang.parser;

import com.github.javaparser.ast.CompilationUnit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.PathUtils;
import lets.core.StringUtils;
import lets.core.file.FindFileSupport;
import lets.core.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LangTransformer {

  protected LangFeatures sourceFeatures;
  protected LangPrettyPrinter targetPrinter;
  protected LangFeatures targetFeatures;
  public final Logger logger = LoggerFactory.getLogger(LangTransformer.class);

  public LangTransformer(
      LangFeatures sourceFeatures, LangFeatures targetFeatures, LangPrettyPrinter targetPrinter) {
    this.sourceFeatures = sourceFeatures;
    this.targetFeatures = targetFeatures;
    this.targetPrinter = targetPrinter;
  }

  public DataResultSupport<List<File>> transform(
      File sourceLangSrcDirectory, File targetLangSrcDirectory) {
    this.logger.info(
        "transform: sourceLangSrcDirectory={} targetLangSrcDirectory={}",
        sourceLangSrcDirectory,
        targetLangSrcDirectory);
    DataResultSupport<List<File>> result = new DataResultSupport<List<File>>();
    List<File> targetSrcFiles = new ArrayList<>();
    result.setData(targetSrcFiles);
    try {
      // pre:
      CoreUtils.checkNotNull(sourceLangSrcDirectory, "sourceLangSrcDirectory not allow null.");
      CoreUtils.checkNotNull(targetLangSrcDirectory, "targetLangSrcDirectory not allow null.");
      CoreUtils.checkState(sourceLangSrcDirectory.exists(), "sourceLangSrcDirectory not exists.");
      if (!targetLangSrcDirectory.exists()) {
        targetLangSrcDirectory.mkdirs();
      }
      String sourceFileExtension = this.sourceFeatures.getSourceFileExtension();
      CoreUtils.checkState(
          StringUtils.isNotEmpty(sourceFileExtension),
          "Source: SourceFileExtension not allow empty.");
      String targetFileExtension = this.targetFeatures.getSourceFileExtension();
      CoreUtils.checkState(
          StringUtils.isNotEmpty(targetFileExtension),
          "Target: SourceFileExtension not allow empty.");

      // find source
      FindFileSupport sourceFind = new FindFileSupport();
      sourceFind.withSearchPath(sourceLangSrcDirectory);
      sourceFind.withIncludeDirs(false);
      sourceFind.withRecursive(true);
      sourceFind.withIncludeWildcard("**/*." + sourceFileExtension);
      List<File> sourceFiles = sourceFind.findAll();
      for (File sourceFile : sourceFiles) {
        this.logger.info("transform: sourceFile={}", sourceFile);
        String relativePath = PathUtils.getRelativePath(sourceLangSrcDirectory, sourceFile);
        File targetFile = new File(targetLangSrcDirectory, relativePath);
        targetFile = FileUtils.setExtension(targetFile, targetFileExtension);
        this.logger.info("transform: targetFile={}", targetFile);

        DataResultSupport<CompilationUnit> source =
            this.sourceFeatures.compilationUnitFrom(sourceFile);
        if (source.isSuccess()) {
          CompilationUnit sourceUnit = source.getData();
          String targetUnit = this.targetPrinter.print(sourceUnit);
          try {
            FileUtils.writeStringToFile(
                targetFile, targetUnit, this.targetFeatures.getSourceFileEncoding());
            this.logger.info("transform: write targetFile={}.", targetFile);
            targetSrcFiles.add(targetFile);
          } catch (Throwable ioe) {
            this.logger.error(
                "transform: write targetFile={} error={}", targetFile, ioe.getMessage());
          }
        } else {
          this.logger.error("Parser: source={} Error={}", sourceFile, source.getMessage());
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
