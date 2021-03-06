/*
 * Copyright (c) 2018.
 *
 * This file is part of XmlUtil.
 *
 * This file is licenced to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You should have received a copy of the license with the source distribution.
 * Alternatively, you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package nl.adaptivity.xmlutil.serialization.compat

@Deprecated("Use proper types", ReplaceWith("kotlinx.serialization.SerializationStrategy"))
typealias SerializationStrategy<T> = kotlinx.serialization.SerializationStrategy<T>

@Deprecated("Use proper types", ReplaceWith("kotlinx.serialization.DeserializationStrategy"))
typealias DeserializationStrategy<T> = kotlinx.serialization.DeserializationStrategy<T>


@Deprecated("Use proper types", ReplaceWith("kotlinx.serialization.Serializer"))
typealias Serializer<T> = kotlinx.serialization.KSerializer<T>
