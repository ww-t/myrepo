"""
james2.txt, julie2.txt, mikey2.txt, sarah2.txt 파일에는 각각
james, julie, mikey, sarah의 1000m 기록이 들어있다. 
(첨부파일 참조)

문제 5) 아래 코드를 설명하라. 특히 sanitize 함수와 get_coach_data 함수가 하는 일을 중심으로 설명하라. 
"""

def sanitize(time_string): #여러가지 방식으로 기록된 1000m 기록들을 '.'을 사용한 표기로 통일 시킴
    if '-' in time_string:
        splitter = '-'
    elif ':' in time_string:
        splitter = ':'
    else:
        return(time_string)
    (mins, secs) = time_string.split(splitter)
    return(mins + '.' + secs)

def get_coach_data(filename): #파일에 저장된 이름, 날짜, 기록들을 쪼개서 사전식으로 리턴 이때 기록은 빠른 기록 3개만 리턴
    try:
        with open(filename) as f:
            data = f.readline()
        templ = data.strip().split(',')
        return({'Name' : templ.pop(0),
                'DOB'  : templ.pop(0),
                'Times': str(sorted(set([sanitize(t) for t in templ]))[0:3])})
    except IOError as ioerr:
        print('File error: ' + str(ioerr))
        return(None)
    
james = get_coach_data('james2.txt')
julie = get_coach_data('julie2.txt')
mikey = get_coach_data('mikey2.txt')
sarah = get_coach_data('sarah2.txt')

print(james['Name'] + "'s fastest times are: " + james['Times'])
print(julie['Name'] + "'s fastest times are: " + julie['Times'])
print(mikey['Name'] + "'s fastest times are: " + mikey['Times'])
print(sarah['Name'] + "'s fastest times are: " + sarah['Times'])
