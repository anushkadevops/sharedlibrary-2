import groovy.json.JsonSlurper 

@NonCPS
showRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
//def repoName = resultJson.name
def rid = resultJson.id
//def projUrl = resultJson.url

httpRequest authentication: 'nexus_cred', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']],contentType: "APPLICATION_JSON", 
    
    httpMode: 'GET', url: "http://3.15.18.214:8081/nexus/service/local/repositories/${rid}"
}
	def call(){
def request = libraryResource 'detail.json'
showRepo(request)
}