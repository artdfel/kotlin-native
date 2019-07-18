/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package codegen.coroutines.functionReference_eqeq_name

import kotlin.test.*

suspend fun foo(x: Int) = x

class Foo(val x: Int) {
    suspend fun bar() = x
}

@Test fun runTest() {
    val ref1 = ::foo
    val rec = Foo(42)
    val ref2 = rec::bar
    val ref3 = ::foo
    val ref4 = Foo(42)::bar
    val ref5 = rec::bar
    println(ref1.name)
    println(ref2.name)
    println(ref1 == ref2)
    println(ref1 == ref3)
    println(ref2 == ref4)
    println(ref2 == ref5)
}
