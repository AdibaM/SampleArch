package com.adibam.core.network.params

import org.junit.Test
import kotlin.test.assertEquals

class ChartsApiParamsBuilderTest {

    private val underTest = ChartsApiParamsBuilder()

    @Test
    fun `Will compose base params correctly`() {

        val params = underTest.chartsParams()
        assertEquals("chart.gettopartists", params["method"])
        assertEquals("0d38b9dc4dd5c46b0617c11db65d642d", params["api_key"])
        assertEquals("json", params["format"])
        assertEquals("5", params["limit"])
    }

}