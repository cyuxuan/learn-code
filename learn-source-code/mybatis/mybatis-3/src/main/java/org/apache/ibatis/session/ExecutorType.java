/*
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

/**
 * {@link ExecutorType#SIMPLE} 该模式下它为每个语句的执行创建一个新的预处理语句，单条提交sql
 * {@link ExecutorType#REUSE}  这个执行器类型会复用预处理语句
 * {@link ExecutorType#BATCH} 模式重复使用已经预处理的语句,并且批量执行所有更新语句
 *
 * @author Clinton Begin
 */
public enum ExecutorType {
  SIMPLE, REUSE, BATCH
}
