@ rem ----- ��Ϣ -----
@ rem @filename Config.bat
@ rem @version 1.0
@ rem @author qye.zheng
@ rem @description CXF ����

@ rem @warning Ϊ�˷�ֹ���Ļ������룬�����ļ���ʱ��Ӧ�ñ���ΪANSI�����ʽ.
@ rem ################################################################################


@ rem ����
@ title CXF ����
@ rem ########## begin  ##########

@ rem �ر���ʾ���ʹ��������ִ��ǰ����ʾ
@ rem @ echo off
@ echo off
@ rem ��������ʾ @ echo on

:: ��ȡbat�ļ����ڵĴ��������������� C:
set currentDriver=%~dp0
set currentDriver=%currentDriver:~0,2%
:: ִ��������������ű������뵱ǰ�ű����ڵ�·��
%currentDriver%
cd %~dp0

@ rem ----- ����������

:: �û�����
:: ����WebService url http://localhost:8080/CXF2/services/SimpleService?wsdl
set WS_URL=http://localhost:8080/CXF2/services/SearchService

:: �����·��
set OUT_PACKAGE=com.hua.client


:: ϵͳ����
:: CXF2 ��Ŀ¼
set CXF2_HOME=D:\software\apache-cxf-3.1.1

set BIN_PATH=%CXF2_HOME%\bin

set OUT_PATH=%~dp0
set OUT_PATH=%OUT_PATH%out

:: maven �ķ�ʽ
:: Դ�� ���·��
:: ������һ��·������Ŀ��·��
:: cd ..
:: set OUT_PATH=%cd%\src\main\java

@ rem ----- ���������

@ rem pause

@ rem

@ rem
@ rem �����ʾ��Ϣ

::
:: 1) 
:: 2)
:: 3)
:: 4)
:: 5)
:: 6)
:: 7)
:: 8)
:: 9)
:: 10)

:: �ڳ����ĩβ�����Ը���ִ�еĽ��(�ɹ���ʧ��) ������ʾ��Ϣ���ɹ�����ֱ��ִ��exit����ʧ��
:: ����ִ��pause��Ȼ�����ͨ������̨�����Ϣ�����ԡ���λ����.
:: �����ڳ���������һ���ɹ���ʧ�ܵı�־-����ֵ���������������ִ������.

@ rem echo
@ rem exit
@ rem ########## end of ##########

@ rem ע��˵��: @ rem ע������  ���� :: ע������
@ rem rem ������ð�� ���� ������дע��
