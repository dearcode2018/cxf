@ rem ----- ��Ϣ -----
@ rem @filename CXFClientStarter.bat
@ rem @version 1.0
@ rem @author qye.zheng
@ rem @description CXFClientStarter  �ͻ��˴������� - ������

@ rem @warning Ϊ�˷�ֹ���Ļ������룬�����ļ���ʱ��Ӧ�ñ���ΪANSI�����ʽ.
@ rem ################################################################################

:: ��ȡbat�ļ����ڵĴ��������������� C:
set currentDriver=%~dp0
set currentDriver=%currentDriver:~0,2%
:: ִ��������������ű������뵱ǰ�ű����ڵ�·��
%currentDriver%
cd %~dp0

:: ִ�� �ű�
call Config.bat

:: ��ȡbat�ļ����ڵĴ��������������� C:
set currentDriver=%~dp0
set currentDriver=%currentDriver:~0,2%
:: ִ��������������ű������뵱ǰ�ű����ڵ�·��
%currentDriver%
cd %~dp0

@ rem ����
@ title CXFStarter������
@ rem ########## begin  ##########

@ rem �ر���ʾ���ʹ��������ִ��ǰ����ʾ
@ rem @ echo off
@ echo off
@ rem ��������ʾ @ echo on

@ rem ----- ����������

@ rem ----- ���������

:: ���� CXF2��Ŀ¼
cd %CXF2_HOME%
:: ���� bin Ŀ¼
cd bin

wsdl2java -wsdlLocation %WS_URL%?wsdl -p %OUT_PACKAGE%  -d %OUT_PATH%

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
