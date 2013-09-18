package org.thestrangeloop.couchbase

import com.couchbase.client.CouchbaseClient
import com.couchbase.client.protocol.views.Query
import groovy.json.JsonSlurper
import spock.lang.Specification

class CouchbaseSpec extends Specification {
    def hostUris = [new URI('http://192.168.210.100:8091/pools')]
    def bucketName = 'default'
    def password = ''
    def slurper = new JsonSlurper()

    CouchbaseClient client

    def setup() {
        client = new CouchbaseClient(hostUris, bucketName, password)
    }

    def "client should exist"() {
        expect:
        client
    }

    def "should be able to get documents from view"() {
        when:
        def view = client.getView('dev_test', 'test')
        def query = new Query(includeDocs: true)
        def response = client.query(view, query)

        then:
        response.each { row ->
            println slurper.parseText(row.document)
        }
    }
}
