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

package nl.adaptivity.xmlutil.util.impl

import nl.adaptivity.xmlutil.SimpleNamespaceContext
import nl.adaptivity.xmlutil.prefixesFor
import java.util.HashSet

class FragmentNamespaceContext(
    val parent: FragmentNamespaceContext?,
    prefixes: Array<String>,
    namespaces: Array<String>
                              ) : SimpleNamespaceContext(prefixes, namespaces) {

    override fun getNamespaceURI(prefix: String): String {
        return parent?.getNamespaceURI(prefix) ?: super.getNamespaceURI(prefix)
    }

    override fun getPrefix(namespaceURI: String): String? {
        return super.getPrefix(namespaceURI) ?: parent?.getPrefix(namespaceURI)
    }

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun getPrefixesCompat(namespaceURI: String): Iterator<String> {
        if (parent == null) {
            return super.getPrefixesCompat(namespaceURI)
        }
        val prefixes = HashSet<String>()

        super.getPrefixesCompat(namespaceURI).forEach { prefixes.add(it) }

        parent.prefixesFor(namespaceURI).asSequence()
            .filter { prefix -> getLocalNamespaceUri(prefix) == null }
            .forEach { prefixes.add(it) }

        return prefixes.iterator()
    }

    private fun getLocalNamespaceUri(prefix: String): String? {
        return indices.lastOrNull { prefix == getPrefix(it) }?.let { getNamespaceURI(it) }
    }
}