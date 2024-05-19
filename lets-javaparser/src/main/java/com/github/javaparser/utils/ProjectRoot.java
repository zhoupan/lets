/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.utils;

import com.github.javaparser.ParserConfiguration;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The structure of a Java project directory. It was originally created specifically to quickly
 * configure the symbol solver. You can use it as a general container for project information.
 *
 * <p>A project has a root directory, and it has zero or more directories that contain source code.
 *
 * <p>To create a ProjectRoot use a CollectionStrategy, or instantiate ProjectRoot yourself.
 */
public class ProjectRoot {

  private final Path root;

  private final Map<Path, SourceRoot> cache = new ConcurrentHashMap<>();

  private final ParserConfiguration parserConfiguration;

  public ProjectRoot(Path root) {
    this(root, new ParserConfiguration());
  }

  public ProjectRoot(Path root, ParserConfiguration parserConfiguration) {
    this.root = root;
    this.parserConfiguration = parserConfiguration;
  }

  public Optional<SourceRoot> getSourceRoot(Path sourceRoot) {
    return Optional.ofNullable(cache.get(sourceRoot));
  }

  public List<SourceRoot> getSourceRoots() {
    return new ArrayList<>(cache.values());
  }

  public void addSourceRoot(Path path) {
    cache.put(path, new SourceRoot(path).setParserConfiguration(parserConfiguration));
  }

  public Path getRoot() {
    return root;
  }

  @Override
  public String toString() {
    return "ProjectRoot at " + root + " with " + cache.values().toString();
  }
}
