import groovy.json.*
def call()
{
  sh "curl -X GET -s -u Priyakumar:pri4jay16 https://gitlab.com/api/v4/projects/17097955/repository/commits -o ouput.json"
  def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  def size = resultJson.size()
  println(size)
  for(i=0;i<size;i++){
//def list[i]=resultJson[i].committer_name
  //println(list[i])
def commit=resultJson[i].committed_date
println(commit)
  }
  for(i=0;i<size;i++){
def uname=resultJson[i].committer_name
    if(uname==list[i]){ count++ }
    else { count1++ }
    println(count)
    println(count1)
 
  //ef val=arr  { reg
  //println(val)
}
}
