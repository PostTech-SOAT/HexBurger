##############################################################################
#                      GENERAL                                               #
##############################################################################

application = "hexburger"
aws_region  = "us-east-1"

##############################################################################
#                      HELM                                                  #
##############################################################################

ingress_nginx_name = "hexburger-ingress"

helm_service_template = [{
  name       = "hexburger"
  namespaces = "deploy"
  helm_chart_key_value = {
    "chartName"                                     = "hexburguer"
    "serviceAccount.create"                         = "true"
    "serviceAccount.name"                           = "hexburger-svc-acc"
    "service.type"                                  = "ClusterIP"
    "service.port"                                  = "8080"
    "service.targetPort"                            = "8080"
    "ingress.enabled"                               = "true"
    "image.pullPolicy"                              = "Always"
    "resources.requests.cpu"                        = "100m"
    "resources.requests.memory"                     = "256Mi"
    "resources.limits.cpu"                          = "200m"
    "resources.limits.memory"                       = "512Mi"
    "liveProbe.initialDelaySeconds"                 = "300"
    "liveProbe.periodSeconds"                       = "90"
    "liveProbe.timeoutSeconds"                      = "30"
    "readyProbe.initialDelaySeconds"                = "300"
    "readyProbe.periodSeconds"                      = "90"
    "readyProbe.timeoutSeconds"                     = "30"
    "autoscaling.enabled"                           = "true"
    "autoscaling.minReplicas"                       = "1"
    "autoscaling.maxReplicas"                       = "3"
    "autoscaling.targetCPUUtilizationPercentage"    = "70"
    "autoscaling.targetMemoryUtilizationPercentage" = "70"
    "secretName"                                    = "hexburger-sm"
    "configMap.enabled"                             = "true"
    "configMap.name"                                = "hexburger-cm"
    "nameOverride"                                  = "hexburguer"
    "fullnameOverride"                              = "hexburguer-api"
  }

  config_map_values = {}


}]
