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
package org.apache.seatunnel.app.dal.entity;

import org.apache.seatunnel.engine.core.job.JobStatus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_st_job_metrics_history")
/**
 * We will expand the JobMetricsHistory metric in the future, so we did not use the JobMetrics table
 */
public class JobMetricsHistory {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField("job_instance_id")
    private Long jobInstanceId;

    @TableField("pipeline_id")
    private Integer pipelineId;

    @TableField("read_row_count")
    private long readRowCount;

    @TableField("write_row_count")
    private long writeRowCount;

    @TableField("source_table_names")
    private String sourceTableNames;

    @TableField("sink_table_names")
    private String sinkTableNames;

    @TableField("read_qps")
    private long readQps;

    @TableField("write_qps")
    private long writeQps;

    @TableField("record_delay")
    private long recordDelay;

    @TableField("status")
    private JobStatus status;

    @TableField("create_user_id")
    private Integer createUserId;

    @TableField("update_user_id")
    private Integer updateUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @TableField("create_time")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
