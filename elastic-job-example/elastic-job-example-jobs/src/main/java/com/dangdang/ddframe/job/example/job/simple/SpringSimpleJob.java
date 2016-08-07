/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.job.example.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.type.simple.api.SimpleJob;
import com.dangdang.ddframe.job.example.fixture.repository.FooRepository;

import java.util.Date;

public class SpringSimpleJob implements SimpleJob {
    
    private FooRepository fooRepository = new FooRepository();
    
    @Override
    public void execute(final ShardingContext shardingContext) {
        System.out.println(new Date() + ":------simple job-------:" + shardingContext);
        fooRepository.findActive(shardingContext.getShardingItemParameters().keySet());
    }
}