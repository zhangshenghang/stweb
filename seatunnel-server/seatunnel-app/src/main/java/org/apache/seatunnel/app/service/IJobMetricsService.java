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

package org.apache.seatunnel.app.service;

import org.apache.seatunnel.app.dal.entity.JobInstance;
import org.apache.seatunnel.app.dal.entity.JobMetricsHistory;
import org.apache.seatunnel.app.domain.response.metrics.JobDAG;
import org.apache.seatunnel.app.domain.response.metrics.JobPipelineDetailMetricsRes;
import org.apache.seatunnel.app.domain.response.metrics.JobPipelineSummaryMetricsRes;
import org.apache.seatunnel.app.domain.response.metrics.JobSummaryMetricsRes;
import org.apache.seatunnel.common.constants.JobMode;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

public interface IJobMetricsService {

    List<JobPipelineSummaryMetricsRes> getJobPipelineSummaryMetrics(@NonNull Long jobInstanceId);

    List<JobPipelineDetailMetricsRes> getJobPipelineDetailMetricsRes(@NonNull Long jobInstanceId);

    JobDAG getJobDAG(@NonNull Long jobInstanceId) throws JsonProcessingException;

    public List<JobPipelineDetailMetricsRes> getJobPipelineDetailMetricsRes(
            @NonNull JobInstance jobInstance);

    ImmutablePair<Long, String> getInstanceIdAndEngineId(@NonNull String key);

    void syncJobDataToDb(@NonNull JobInstance jobInstance, @NonNull String jobEngineId);

    JobSummaryMetricsRes getJobSummaryMetrics(
            @NonNull Long jobInstanceId, @NonNull String jobEngineId);

    Map<Long, JobSummaryMetricsRes> getALLJobSummaryMetrics(
            @NonNull Map<Long, Long> jobInstanceIdAndJobEngineIdMap,
            @NonNull List<Long> jobInstanceIdList,
            @NonNull JobMode jobMode);

    /**
     * Get job metrics history data
     *
     * @param jobInstanceId job instance id
     * @return List of metrics data points
     */
    List<JobMetricsHistory> getJobMetricsHistory(@NonNull Long jobInstanceId);

    List<JobMetricsHistory> getJobMetricsHistory(
            Long jobInstanceId, String startTime, String endTime);
}
