package com.dsuzuki.todoappbackend.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchUnitRunner
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.junit.runner.RunWith

@RunWith(ArchUnitRunner::class)
@AnalyzeClasses(packages = ["com.dsuzuki.todoappbackend"])
class TestPresentationRules {

    @ArchTest
    fun presentationレイヤのクラスは他のレイヤのクラスから依存されない(classes: JavaClasses) {

        val rule = ArchRuleDefinition.noClasses().that()
            .resideOutsideOfPackage("..presentation..").should()
            .accessClassesThat().resideInAPackage("..presentation..")

        rule.check(classes)
    }
}
