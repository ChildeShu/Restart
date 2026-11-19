package com.childeshu.restart;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;

/**
 * 重启 IDE：File 菜单 -> Restart，或 Ctrl + Alt + R。
 *
 * @author childe shu
 */
public class Restart extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        ApplicationManager.getApplication().restart();
    }
}
