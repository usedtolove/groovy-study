/**
 * 无损音乐 ape格式==>flac格式 转码程序:
 * 使用之前
 * 1.先安装 ffmpeg，以及groovy环境
 * 2.找到需要转换的ape文件目录
 * 3.在目录下打开groovyConsole,导入这个源代码
 * 4.执行
*/
println "自定义转码程序开始执行"

//读取当前目录
fileList = new File('./')
//已转换文件计数器
count = 0;

//todo
//如果强制执行，删除原有的 *.flac 文件

//迭代文件
fileList.eachFile{f->  
    //文件名
    a = f.name
    //判断是否属于 *.ape 文件
    if(a.endsWith('.ape')){
        //打印原来的文件名
        println 'file a:'+a
        b = a.replace('.ape','.flac')
        //打印转换后的文件名
        println 'file b:'+b
        //拼接指令数组        
        def cmd = ['ffmpeg', '-i', "$a", "$b"]
        //println cmd

        //调用 Process 执行指令
        Process p = cmd.execute()
        //等待执行
        p.waitForProcessOutput(System.out, System.out)
        //获取执行返回整型
        def exitValue =p.exitValue()
        if(!exitValue)
            //println "exitValue:"+exitValue 
            //如果为0，表示执行成功
            if(exitValue == 0)
                count++   
                                    
    }    
};

println "自定义转码程序开始完毕,转换 $count 个文件!"
