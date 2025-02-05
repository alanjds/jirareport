package br.com.jiratorio.domain.jira.changelog

class JiraChangelog(
    val startAt: Long,
    val maxResults: Long,
    val total: Long,
    val histories: List<JiraChangelogHistory>
)
