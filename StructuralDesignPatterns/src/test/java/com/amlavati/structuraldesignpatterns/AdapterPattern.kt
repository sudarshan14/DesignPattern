package com.amlavati.structuraldesignpatterns

import android.view.Display
import org.assertj.core.api.Assertions
import org.junit.Test

// this is third party functionality

data class DisplayDataType(val index: Float, val data: String)

class DataDisplay {

    fun display(data: DisplayDataType) {
        println("Data is displayed ${data.index} - ${data.data}")
    }
}
//----------------

// our code

data class DatabaseData(val position: Int, val amount: Int)

class DatabaseDataGenerator {
    fun generateData(): List<DatabaseData> {
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(1, 30))
        list.add(DatabaseData(2, 50))
        list.add(DatabaseData(3, 80))
        return list
    }
}

interface DatabaseDataConvertor {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(private val display: DataDisplay) : DatabaseDataConvertor {
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()

        for (datum in data) {
            val ddt = DisplayDataType(datum.position.toFloat(), datum.amount.toString())
            display.display(ddt)
            returnList.add(ddt)
        }

        return returnList
    }

}

class AdapterTest {

    @Test
    fun adapterTest() {

        val generator = DatabaseDataGenerator()
        val generatedData = generator.generateData()

        val adapter = DataDisplayAdapter(DataDisplay())
        val convertData = adapter.convertData(generatedData)

        Assertions.assertThat(convertData.size).isEqualTo(3)
        Assertions.assertThat(convertData[1].index).isEqualTo(2f)
    }
}
