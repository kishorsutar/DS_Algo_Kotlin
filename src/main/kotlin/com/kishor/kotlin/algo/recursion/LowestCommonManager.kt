package com.kishor.kotlin.algo.recursion

class OrgChart(name: Char) {
    val name = name
    val directReports = mutableListOf<OrgChart>()
}


//fun getLowestCommonManager(topManager: OrgChart, empOne: OrgChart, empTwo: OrgChart): OrgChart? {
//    val managerStack = Stack<OrgChart>()
//
//    for (report in topManager.directReports) {
//        if (isBothReportsAvailable(empOne, empTwo, report)) {
//            managerStack.push(report)
//        }
//    }
//
//    if (managerStack.size > 0) return managerStack.pop()
//    else return topManager
//
//}

fun isBothReportsAvailable(empOne: OrgChart, empTwo: OrgChart, newManager: OrgChart): Boolean {
    var manager = newManager
    return isReportAvailable(manager, empOne) && isReportAvailable(manager, empTwo)

}

fun isReportAvailable(currentManager: OrgChart, emp: OrgChart): Boolean {
    var manager = currentManager
    if (manager == null) return false
    if (manager.name == emp.name) return true
    else {
        for (child in manager.directReports) {
            isReportAvailable(child, emp)
        }
    }

    return true
}

// ---------------------------------------//

data class OrgInfo(
    val lowestCommonManager: OrgChart?,
    val numRelatedReports: Int
)

// time O(n) space O(n) for recursion stack
fun getLowestCommonManager(topManager: OrgChart, reportOne: OrgChart, reportTwo: OrgChart): OrgChart? {

    return getReportsInfo(topManager, reportOne, reportTwo).lowestCommonManager

}

fun getReportsInfo(manager: OrgChart, reportOne: OrgChart, reportTwo: OrgChart): OrgInfo {
    // base case - if manager has null value or it's a report // itself
    var numOfRelatedReport = 0

    for (directReport in manager.directReports) {
        val orgInfo = getReportsInfo(directReport, reportOne, reportTwo)
        if (orgInfo.lowestCommonManager != null) return orgInfo
        numOfRelatedReport += orgInfo.numRelatedReports
    }
    if (manager == reportOne || manager == reportOne) numOfRelatedReport++
    val lowestCommonManger: OrgChart? = if (numOfRelatedReport == 2) manager else null
    val newOrgInfo = OrgInfo(lowestCommonManger, numOfRelatedReport)
    return newOrgInfo

}
