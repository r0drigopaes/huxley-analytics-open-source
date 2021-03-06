package com.thehuxley.analytics.controller

import com.mongodb.util.JSON
import com.thehuxley.analytics.domain.Statistic
import com.thehuxley.analytics.service.DataService
import com.thehuxley.analytics.service.DatabaseService
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quiz")
class QuizController {

    @Autowired
    DataService dataService

    @RequestMapping("/{id}")
    def get(@PathVariable(value = "id") Long id, @RequestParam(value = "key", required = false) String key) {
        def tempResponse = dataService.getQuizStatistic(id)
        if (key) {
            tempResponse = [(key): tempResponse[key]]
        }
        return dataService.getResponse(tempResponse)
    }

}
