/**
 * Copyright 2012 Muzima Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mclinic.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mclinic.api.configuration.Configuration;
import com.mclinic.search.api.logger.LogLevel;
import com.mclinic.util.Constants;

public class MuzimaModule extends AbstractModule {

    private String repositoryPath;

    private String documentKey;

    public MuzimaModule(final String repositoryPath, final String documentKey) {
        this.repositoryPath = repositoryPath;
        this.documentKey = documentKey;
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named(Constants.LUCENE_DIRECTORY_NAME)).toInstance(repositoryPath);
        bind(String.class).annotatedWith(Names.named(Constants.LUCENE_DOCUMENT_KEY)).toInstance(documentKey);
        bind(LogLevel.class).toInstance(LogLevel.DEBUG);

        Configuration configuration = new Configuration();
        bind(Configuration.class).toInstance(configuration);
    }
}
