/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seatunnel.app.domain;

import org.apache.seatunnel.app.domain.response.executor.JobExecutorRes;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class JobExecutorResDeserializer extends JsonDeserializer<JobExecutorRes> {

    @Override
    public JobExecutorRes deserialize(
            JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Long jobInstanceId = node.get("jobInstanceId").asLong();
        String jobConfig = node.get("jobConfig").asText();
        String engine = node.get("engine").asText();
        String deployMode = node.get("deployMode").asText();
        String master = node.get("master").asText();
        String jobMode = node.get("jobMode").asText();

        return new JobExecutorRes(jobInstanceId, jobConfig, engine, deployMode, master, jobMode);
    }
}