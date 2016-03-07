package ar.com.ponele.mascotapp.task;

import ar.com.ponele.mascotapp.dto.util.AlertMessage;

public interface CheckTask {

    boolean isValid();

    AlertMessage getAlertMessage();
}
