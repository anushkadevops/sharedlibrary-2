import groovy.json.JsonSlurper 

@NonCPS
showRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
//def repoName = resultJson.name
def rid = resultJson.id
//def projUrl = resultJson.url

httpRequest authentication: 'nexus_cred',contentType: "application/json", 
    
    httpMode: 'GET', url: "http://3.15.18.214:8081/nexus/service/local/repositories/${rid}/status"
}
	def call(){
def request = libraryResource 'nexus.json'
showRepo(request)
}
