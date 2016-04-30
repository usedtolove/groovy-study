/**
 * recursion delete files
 * 
 * @author hjl
 * @since 2016-04-30
 */
class DeleteFiles {

    def static dir = 'E:/oschina/openCV3'
    def static suffix = '.pro.user'
    def static count = 0
    
    static void main(String[] args){
        println 'start...'
        
        def folder = new File(dir)

        if(folder.exists()){
            recursion(folder)
        }
        
        println "delete $count file(s)"
        println 'end...'
    }

    def static recursion(File folder){
        folder.listFiles().each{
            if(it.isFile() && it.name.endsWith(suffix)){
                println "delete $it.name"
                count++
                it.delete()
            }else{
                recursion(it)
            }
        }
    }
}