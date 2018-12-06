import groovy.json.JsonSlurper

def parsed_args = new JsonSlurper().parseText(args)

if(arg.name == null) {
    return "you need to provid a repository 'name'"
}

Repository repo = repository.repositoryManager.get(arg.name)

if (repo != null) {
    try {
        repository.repositoryManager.delete(repo.name)
        repo.destroy()
    } catch(Exception e) {
        return e.toString()
    }
    return true
}