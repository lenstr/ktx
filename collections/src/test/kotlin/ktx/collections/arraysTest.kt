package ktx.collections

import org.junit.Assert.*
import org.junit.Test
import java.util.LinkedList

/**
 * Tests utilities for LibGDX custom ArrayList equivalent - Array.
 */
class ArraysTest {
  @Test
  fun `should create Array`() {
    val array = gdxArrayOf<Any>()

    assertNotNull(array)
    assertTrue(array is GdxArray)
    assertEquals(0, array.size)
  }

  @Test
  fun `should create Array with custom initial capacity`() {
    assertEquals(32, gdxArrayOf<Any>(initialCapacity = 32).items.size)
    assertEquals(128, gdxArrayOf<Any>(initialCapacity = 128).items.size)
  }

  @Test
  fun `should create Arrays with custom ordered setting`() {
    assertFalse(gdxArrayOf<Any>(ordered = false).ordered)
    assertTrue(gdxArrayOf<Any>(ordered = true).ordered)
  }

  @Test
  fun `should create Array with custom elements`() {
    val array = gdxArrayOf("1", "2", "3")

    assertEquals(3, array.size)
    assertTrue("1" in array)
    assertTrue("2" in array)
    assertTrue("3" in array)
  }

  @Test
  fun `should report size of Array`() {
    val array = GdxArray.with("1", "2", "3")

    assertEquals(3, array.size())
    assertEquals(array.size, array.size())
  }

  @Test
  fun `should return 0 as null Array size`() {
    val nullArray: GdxArray<Any>? = null

    assertEquals(0, nullArray.size())
  }

  @Test
  fun `should report size of IntArray`() {
    val array = GdxIntArray.with(1, 2, 3)

    assertEquals(3, array.size())
    assertEquals(array.size, array.size())
  }

  @Test
  fun `should return 0 as null IntArray size`() {
    val nullArray: GdxIntArray? = null

    assertEquals(0, nullArray.size())
  }

  @Test
  fun `should report size of FloatArray`() {
    val array = GdxFloatArray.with(1f, 2f, 3f)

    assertEquals(3, array.size())
    assertEquals(array.size, array.size())
  }

  @Test
  fun `should return 0 as null FloatArray size`() {
    val nullArray: GdxFloatArray? = null

    assertEquals(0, nullArray.size())
  }

  @Test
  fun `should report size of BooleanArray`() {
    val array = GdxBooleanArray.with(true, false, true)

    assertEquals(3, array.size())
    assertEquals(array.size, array.size())
  }

  @Test
  fun `should return 0 as null BooleanArray size`() {
    val nullArray: GdxBooleanArray? = null

    assertEquals(0, nullArray.size())
  }

  @Test
  fun `should report empty status`() {
    assertFalse(GdxArray.with("1", "2", "3").isEmpty())
    assertTrue(GdxArray<Any>().isEmpty())
    assertTrue((null as GdxArray<Any>?).isEmpty())
  }

  @Test
  fun `should report non empty status`() {
    assertTrue(GdxArray.with("1", "2", "3").isNotEmpty())
    assertFalse(GdxArray<Any>().isNotEmpty())
    assertFalse((null as GdxArray<Any>?).isNotEmpty())
  }

  @Test
  fun `should return last valid index of Array`() {
    val array = GdxArray.with("1", "2", "3")

    assertEquals(2, array.lastIndex)
  }

  @Test
  fun `should return last valid index of empty Array`() {
    val emptyArray = GdxArray<Any>()

    assertEquals(-1, emptyArray.lastIndex)
  }

  @Test
  fun `should return negative last index for null Array`() {
    val nullArray: GdxArray<Any>? = null

    assertEquals(-1, nullArray.lastIndex)
  }

  @Test
  fun `should return last valid index of IntArray`() {
    val array = GdxIntArray.with(1, 2, 3)

    assertEquals(2, array.lastIndex)
  }

  @Test
  fun `should return last valid index of empty IntArray`() {
    val emptyArray = GdxIntArray()

    assertEquals(-1, emptyArray.lastIndex)
  }

  @Test
  fun `should return negative last index for null IntArray`() {
    val nullArray: GdxIntArray? = null

    assertEquals(-1, nullArray.lastIndex)
  }

  @Test
  fun `should return last valid index of FloatArray`() {
    val array = GdxFloatArray.with(1f, 2f, 3f)

    assertEquals(2, array.lastIndex)
  }

  @Test
  fun `should return last valid index of empty FloatArray`() {
    val emptyArray = GdxFloatArray()

    assertEquals(-1, emptyArray.lastIndex)
  }

  @Test
  fun `should return negative last index for null FloatArray`() {
    val nullArray: GdxFloatArray? = null

    assertEquals(-1, nullArray.lastIndex)
  }

  @Test
  fun `should return last valid index of BooleanArray`() {
    val array = GdxBooleanArray.with(true, false, true)

    assertEquals(2, array.lastIndex)
  }

  @Test
  fun `should return last valid index of empty BooleanArray`() {
    val emptyArray = GdxBooleanArray()
    assertEquals(-1, emptyArray.lastIndex)
  }

  @Test
  fun `should return negative last index for null BooleanArray`() {
    val nullArray: GdxBooleanArray? = null
    assertEquals(-1, nullArray.lastIndex)
  }

  @Test
  @Suppress("ReplaceGetOrSet")
  fun `should return alternative if element is null`() {
    val array = GdxArray.with("0", null, "2")

    assertEquals("0", array.get(0, "3"))
    assertEquals("3", array[1, "3"]) // This method is also available through square bracket operator.
    assertEquals("2", array.get(2, "3"))
    assertEquals("3", array[3, "3"])
  }

  @Test
  fun `should add all values from Iterable`() {
    val array = GdxArray<String>()

    array.addAll(listOf("1", "2", "3"))

    assertEquals(3, array.size)
    assertTrue("1" in array)
    assertTrue("2" in array)
    assertTrue("3" in array)
  }

  @Test
  fun `should remove all values from Iterable`() {
    val array = GdxArray.with("1", "2", "3")

    array.removeAll(listOf("1", "2", "3"))

    assertEquals(0, array.size)
    assertFalse("1" in array)
    assertFalse("2" in array)
    assertFalse("3" in array)
  }

  @Test
  fun `should remove all values from native Array`() {
    val array = GdxArray.with("1", "2", "3")

    array.removeAll(arrayOf("1", "2", "3"))

    assertEquals(0, array.size)
    assertFalse("1" in array)
    assertFalse("2" in array)
    assertFalse("3" in array)
  }

  @Test
  fun `should add values with + operator`() {
    val array = GdxArray<String>()

    array + "1"

    assertEquals(1, array.size)
    assertTrue("1" in array)
    assertEquals("1", array[0])

    array + "2" + "3"

    assertEquals(3, array.size)
    assertTrue("2" in array)
    assertTrue("3" in array)
    assertEquals("2", array[1])
    assertEquals("3", array[2])
  }

  @Test
  fun `should add Iterables with + operator`() {
    val array = GdxArray<String>()

    array + listOf("1", "2", "3")

    assertEquals(3, array.size)
    assertTrue("1" in array)
    assertTrue("2" in array)
    assertTrue("3" in array)
    assertEquals("1", array[0])
    assertEquals("2", array[1])
    assertEquals("3", array[2])
  }

  @Test
  fun `should add native Arrays with + operator`() {
    val array = GdxArray<String>()

    array + arrayOf("1", "2", "3")

    assertEquals(3, array.size)
    assertTrue("1" in array)
    assertTrue("2" in array)
    assertTrue("3" in array)
    assertEquals("1", array[0])
    assertEquals("2", array[1])
    assertEquals("3", array[2])
  }

  @Test
  fun `should remove values with - operator`() {
    val array = GdxArray.with("1", "2", "3", "4", "5", "6")

    array - "1"

    assertEquals(5, array.size)
    assertFalse("1" in array)

    array - "2" - "3"

    assertEquals(3, array.size)
    assertFalse("2" in array)
    assertFalse("3" in array)

    array - listOf("4", "5")

    assertEquals(1, array.size)
    assertFalse("4" in array)
    assertFalse("5" in array)

    array - arrayOf("6", "7")

    assertEquals(0, array.size)
    assertFalse("6" in array)
    assertFalse("7" in array)
  }

  @Test
  fun `should chain operators`() {
    val array = GdxArray.with("1", "2", "3", "4")

    array + "5" - "2" + GdxArray.with("7") - GdxArray.with("4", "6")

    assertEquals(GdxArray.with("1", "3", "5", "7"), array)
  }

  @Test
  fun `should find elements with in operator`() {
    val array = GdxArray.with("1")
    val identityCheck = false // Will compare with equals(Object).

    assertTrue(array.contains("1", identityCheck)) // Standard LibGDX API.
    assertTrue("1" in array)
    assertTrue(array.contains("1")) // Operator method alias.

    array.removeValue("1", identityCheck)

    assertFalse(array.contains("1", identityCheck)) // Standard LibGDX API.
    assertFalse("1" in array)
    assertFalse(array.contains("1"))
  }

  @Test
  fun `should allow to iterate Array with iterator reference`() {
    val array = GdxArray.with("1", "2", "3")

    array.iterate { value, iterator -> if (value == "2") iterator.remove() }

    assertEquals(2, array.size)
    assertFalse("2" in array)
  }

  @Test
  fun `should sort elements in descending natural order`() {
    val array = GdxArray.with(1, 2, 3)

    array.sortDescending()

    assertEquals(3, array[0])
    assertEquals(2, array[1])
    assertEquals(1, array[2])
  }

  @Test
  fun `should sort elements by property`() {
    val array = GdxArray.with("Twenty-one", "Eleven", "One")

    array.sortBy { it.length }

    assertEquals("One", array[0])
    assertEquals("Eleven", array[1])
    assertEquals("Twenty-one", array[2])
  }

  @Test
  fun `should sort elements by property in descending order`() {
    val array = GdxArray.with("One", "Eleven", "Twenty-one")

    array.sortByDescending { it.length }

    assertEquals("Twenty-one", array[0])
    assertEquals("Eleven", array[1])
    assertEquals("One", array[2])
  }

  @Test
  fun `should map elements into a new GdxArray`() {
    val array = GdxArray.with(1, 2, 3)

    val result = array.map { it * 2 }

    assertTrue(result is GdxArray)
    assertEquals(GdxArray.with(2, 4, 6), result)
  }

  @Test
  fun `should filter elements into a new GdxArray`() {
    val array = GdxArray.with(1, 2, 3, 4, 5)

    val result = array.filter { it % 2 == 1 }

    assertTrue(result is GdxArray)
    assertEquals(GdxArray.with(1, 3, 5), result)
  }

  @Test
  fun `should flatten elements into a new GdxArray`() {
    val array = GdxArray.with(GdxArray.with(1), listOf<Int>(), LinkedList(arrayListOf(2, 3)))

    val result = array.flatten()

    assertTrue(result is GdxArray)
    assertEquals(GdxArray.with(1, 2, 3), result)
  }

  @Test
  fun `should map elements to lists and flatten them into a new GdxArray`() {
    val array = GdxArray.with(1, 2, 3)

    val result = array.flatMap { counter -> List(counter) { counter } }

    assertTrue(result is GdxArray)
    assertEquals(GdxArray.with(1, 2, 2, 3, 3, 3), result)
  }

  @Test
  fun `should convert Array to ObjectSet`() {
    val array = GdxArray.with("1", "2", "3")

    val set = array.toGdxSet()

    assertEquals(3, set.size)
    assertTrue("1" in set)
    assertTrue("2" in set)
    assertTrue("3" in set)
  }

  @Test
  fun `should convert Iterables to Arrays`() {
    val listAsArray = listOf("1", "2", "3").toGdxArray()

    assertEquals(3, listAsArray.size)
    assertTrue("1" in listAsArray)
    assertTrue("2" in listAsArray)
    assertTrue("3" in listAsArray)
    assertEquals("1", listAsArray[0])
    assertEquals("2", listAsArray[1])
    assertEquals("3", listAsArray[2])
  }

  @Test
  fun `should convert native Arrays to GdxArrays`() {
    val array = arrayOf("1", "2", "3").toGdxArray()

    assertEquals(3, array.size)
    assertTrue("1" in array)
    assertTrue("2" in array)
    assertTrue("3" in array)
    assertEquals("1", array[0])
    assertEquals("2", array[1])
    assertEquals("3", array[2])
  }

  @Test
  fun `should convert native IntArrays to GdxIntArrays`() {
    val intArray = intArrayOf(1, 2, 3).toGdxArray()

    assertEquals(3, intArray.size)
    assertTrue(1 in intArray)
    assertTrue(2 in intArray)
    assertTrue(3 in intArray)
    assertEquals(1, intArray[0])
    assertEquals(2, intArray[1])
    assertEquals(3, intArray[2])
  }

  @Test
  fun `should convert native FloatArrays to GdxFloatArrays`() {
    val floatArray = floatArrayOf(1f, 2f, 3f).toGdxArray()

    assertEquals(3, floatArray.size)
    assertTrue(1f in floatArray)
    assertTrue(2f in floatArray)
    assertTrue(3f in floatArray)
    assertEquals(1f, floatArray[0], 0.001f)
    assertEquals(2f, floatArray[1], 0.001f)
    assertEquals(3f, floatArray[2], 0.001f)
  }

  @Test
  fun `should convert native BooleanArrays to GdxBooleanArrays`() {
    val booleanArray = booleanArrayOf(true, false, true).toGdxArray()

    assertEquals(3, booleanArray.size)
    assertEquals(true, booleanArray[0])
    assertEquals(false, booleanArray[1])
    assertEquals(true, booleanArray[2])
  }

  @Test
  fun `should provide aliases for collections with conflicting names`() {
    assertTrue(GdxArray<Any>() is com.badlogic.gdx.utils.Array<Any>)
    assertTrue(GdxIntArray() is com.badlogic.gdx.utils.IntArray)
    assertTrue(GdxFloatArray() is com.badlogic.gdx.utils.FloatArray)
    assertTrue(GdxBooleanArray() is com.badlogic.gdx.utils.BooleanArray)
    assertTrue(GdxCharArray() is com.badlogic.gdx.utils.CharArray)
    assertTrue(GdxLongArray() is com.badlogic.gdx.utils.LongArray)
    assertTrue(GdxShortArray() is com.badlogic.gdx.utils.ShortArray)
  }
}
