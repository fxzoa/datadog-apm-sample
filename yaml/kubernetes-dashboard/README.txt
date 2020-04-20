$ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-rc7/aio/deploy/recommended.yaml

$ kubectl get secrets -n kube-system | grep admin-user 

$TOKEN=((kubectl describe secret secret-name -n kubernetes-dashboard | Sls "token:") -split " +")[1]  # for win10

$TOKEN=kubectl describe secret admin-user-token-rr88x -n kube-system | grep token  

$ kubectl config set-credentials --token=${TOKEN} 

$ kubectl proxy

# chrome access url:
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/.